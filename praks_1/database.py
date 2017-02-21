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


def update(program):
    cursor = db_connect()
    sql = "UPDATE programmeerimiskeel SET name = %s, year = %s, designer = %s WHERE id = %s"
    cursor.execute(sql, (program.name, program.year, program.designer, program.id))
    cursor.commit()
    cursor.close()


def create_objects(records):
    result = ""
    size = len(records)
    for index, record in enumerate(records):
        prlng = programminglanguage.ProgrammingLanguage(record[0], record[1], int(record[2]), record[3])
        result += (json.dumps(prlng.serialize()))
        if index < size -1:
            result += ','
    return result