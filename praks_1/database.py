#!/usr/bin/python

import psycopg2
import json
import programminglanguage


def db_connect():
    conn_string = "host='localhost' dbname='Programmeerimiskeel' user='postgres' password=''"
    # get a connection, if a connect cannot be made an exception will be raised here
    conn = psycopg2.connect(conn_string)
    # conn.cursor will return a cursor object, you can use this cursor to perform queries
    return conn


def make_query(query):
    connection = db_connect()
    cursor = connection.cursor()
    cursor.execute(query)
    objects = create_objects(cursor.fetchall())
    cursor.close()
    connection.close()
    return objects


def update(program):
    conn = db_connect()
    cursor = conn.cursor()
    sql = "UPDATE programmeerimiskeel SET nimi = %s, loomise_aasta = %s, disainer = %s WHERE id = %s"
    cursor.execute(sql, (program.name, program.year, program.designer, program.id))
    conn.commit()
    cursor.close()
    conn.close()

def insert(program):
    conn = db_connect()
    cursor = conn.cursor()
    sql = "INSERT INTO programmeerimiskeel (nimi, loomise_aasta, disainer) VALUES (%s, %s, %s)"
    cursor.execute(sql, (program.name, program.year, program.designer))
    conn.commit()
    cursor.close()
    conn.close()


def create_objects(records):
    result = "["
    size = len(records)
    for index, record in enumerate(records):
        prlng = programminglanguage.ProgrammingLanguage(record[0], record[1], int(record[2]), record[3])
        result += (json.dumps(prlng.serialize()))
        if index < size -1:
            result += ','
    result += "]"
    return result