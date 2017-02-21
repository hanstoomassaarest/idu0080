#!/usr/bin/python

from flask import Flask, jsonify
import database

app = Flask(__name__)


@app.route('/programs/', methods=['GET'])
def fetchAll():
    return database.make_query("SELECT * FROM programmeerimiskeel")
    # return jsonify({'programs': programs})


@app.route('/programs/<int:id>', methods=['GET'])
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
    app.run(debug=True)
