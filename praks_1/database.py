#!/usr/bin/python

import psycopg2
import json
import programminglanguage


def db_connect():
    conn_string = "host='localhost' dbname='Programmeerimiskeel' user='postgres' password='postgres'"
    # get a connection, if a connect cannot be made an exception will be raised here
    conn = psycopg2.connect(conn_string)
    # conn.cursor will return a cursor object, you can use this cursor to perform queries
    return conn.cursor()


def make_query(query):
    cursor = db_connect()
    cursor.execute(query)
    return create_objects(cursor.fetchall())


def create_objects(records):
    result = ""
    for record in records:
        prlng = programminglanguage.ProgrammingLanguage(record[0], record[1], int(record[2]), record[3])
        result += (json.dumps(prlng.serialize()))
    return result