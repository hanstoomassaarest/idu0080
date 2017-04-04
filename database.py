#!/usr/bin/python

import json

import psycopg2

import db_connection
import programminglanguage


def db_connect():
    conn_string = db_connection.get_connection_string()
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


def delete(id):
    conn = db_connect()
    cursor = conn.cursor()
    sql = "DELETE FROM programmeerimiskeel WHERE programmeerimiskeel.id = " + str(id)
    cursor.execute(sql)
    conn.commit()
    cursor.close()
    conn.close()

def search(id, name, designer, year):
    conn = db_connect()
    cursor = conn.cursor()
    where_clause = ""
    id = id.encode('utf-8')
    name = name.encode('utf-8')
    designer = designer.encode('utf-8')
    year = year.encode('utf-8')
    if not id is "":
        where_clause = " id = " + id
    if not name is '':
        if where_clause is "":
            where_clause += " UPPER(nimi) LIKE UPPER('%" + name + "%')"
        else:
            where_clause += " AND UPPER(nimi) LIKE UPPER('%" + name + "%')"
    if not designer is "":
        if where_clause is "":
            where_clause += " UPPER(disainer) LIKE UPPER('%" + designer + "%')"
        else:
            where_clause += " AND UPPER(disainer) LIKE UPPER('%" + designer + "%')"
    if not year is '':
        if where_clause is "":
            where_clause += " loomise_aasta = " + year
        else:
            where_clause += " AND loomise_aasta = " + year
    # If no search params inserted then return all
    if where_clause is '':
        sql = "SELECT * FROM programmeerimiskeel"
    else:
        sql = "SELECT * FROM programmeerimiskeel WHERE" + where_clause
    cursor.execute(sql)
    objects = create_objects(cursor.fetchall())
    cursor.close()
    conn.close()
    return objects