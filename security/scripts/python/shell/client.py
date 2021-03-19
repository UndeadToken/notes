import socket, sys

host = '127.0.0.1', 9994

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(host)

print 'Escape stdin [CTRL + D]'

buffer = sys.stdin.read()

if len(buffer):
    client.send(buffer)

def get_response():
    response = ''
    length = 1

    while length:
        data = client.recv(4096)
        length = len(data)

        response += data

        if length < 4096:
            break

    print response,

def command():
    buffer = raw_input('')
    buffer += '\n'

    client.send(buffer)

while True:
    get_response()
    command()
