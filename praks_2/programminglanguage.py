#!/usr/bin/python


class ProgrammingLanguage:
    def __init__(self, id, name, year, designer):
        self.id = id
        self.name = name
        self.year = year
        self.designer = designer

    def __str__(self):
        return str(self.id) + ', ' + self.name + ', ' + str(self.year) + ', ' + self.designer

    def serialize(self):
        return {
            'id': self.id,
            'name': self.name,
            'year': self.year,
            'designer': self.designer
        }
