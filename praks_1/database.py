#!/usr/bin/python

import psycopg2
import sys
import pprint

def db_connect():
    conn_string = "host='localhost' dbname='Programmeerimiskeel' user='postgres' password='postgres'"
    # get a connection, if a connect cannot be made an exception will be raised here
    conn = psycopg2.connect(conn_string)
    # conn.cursor will return a cursor object, you can use this cursor to perform queries
    cursor = conn.cursor()
    # execute our Query
    cursor.execute("SELECT * FROM Programmeerimiskeel")
    # retrieve the records from the database
    records = cursor.fetchall()
    # print out the records using pretty print
    # note that the NAMES of the columns are not shown, instead just indexes.
    # for most people this isn't very useful so we'll show you how to return
    # columns as a dictionary (hash) in the next example.
    pprint.pprint(records)

def main():
    db_connect()

main()