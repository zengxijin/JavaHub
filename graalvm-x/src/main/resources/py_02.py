import polyglot


class PyObj:
    def __init__(self, name='', age=None):
        self.name = name
        self.age = age


@polyglot.export_value
def get_obj():
    return PyObj('Tom', 39)

