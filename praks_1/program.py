#!/usr/bin/python

from flask import Flask, jsonify
from datetime import timedelta
from flask import make_response, request, current_app
from functools import update_wrapper
import database

app = Flask(__name__)

def crossdomain(origin=None, methods=None, headers=None,
                max_age=21600, attach_to_all=True,
                automatic_options=True):

    if methods is not None:
        methods = ', '.join(sorted(x.upper() for x in methods))
    if headers is not None and not isinstance(headers, basestring):
        headers = ', '.join(x.upper() for x in headers)
    if not isinstance(origin, basestring):
        origin = ', '.join(origin)
    if isinstance(max_age, timedelta):
        max_age = max_age.total_seconds()

    def get_methods():
        if methods is not None:
            return methods

        options_resp = current_app.make_default_options_response()
        return options_resp.headers['allow']

    def decorator(f):
        def wrapped_function(*args, **kwargs):
            if automatic_options and request.method == 'OPTIONS':
                resp = current_app.make_default_options_response()
            else:
                resp = make_response(f(*args, **kwargs))
            if not attach_to_all and request.method != 'OPTIONS':
                return resp

            h = resp.headers

            h['Access-Control-Allow-Origin'] = origin
            h['Access-Control-Allow-Methods'] = get_methods()
            h['Access-Control-Max-Age'] = str(max_age)
            h['Access-Control-Allow-Headers'] = 'Origin, X-Requested-With, Content-Type, Accept'
            if headers is not None:
                h['Access-Control-Allow-Headers'] = 'Origin, X-Requested-With, Content-Type, Accept'
            return resp

        f.provide_automatic_options = False
        return update_wrapper(wrapped_function, f)
    return decorator


@app.route('/programs/', methods=['GET', 'OPTIONS'])
@crossdomain(origin='*')
def fetchAll():
    return database.make_query("SELECT * FROM programmeerimiskeel")
    # return jsonify({'programs': programs})


@app.route('/programs/<int:id>', methods=['GET', 'OPTIONS'])
@crossdomain(origin='*')
def fetchById(id):
    try:
        program_id = int(id)
        result = database.make_query("SELECT * FROM programmeerimiskeel WHERE id = " + str(program_id))
        if result is None or result is "":
            return "No record available with id: " + str(program_id)
        return result
    except ValueError:
        return "ID is not a number"


if __name__ == '__main__':
    # app.run(debug=True)
    app.run()