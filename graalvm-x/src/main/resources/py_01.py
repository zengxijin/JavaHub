import polyglot


@polyglot.export_value
def foo(x):
    print(x)
    return sum(x)


def sum(y):
    return y * 2
