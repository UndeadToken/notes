import socket, threading, subprocess

host = '127.0.0.1', 9994

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(host)
server.listen(5)

def shell(client):
    while True:
        client.send('<shell:#>')

        buffer = ''
        while '\n' not in buffer:
            buffer += client.recv(1024)

        response = exec_command(buffer)
        client.send(response)

def exec_command(command):
    command = command.rstrip()

    try:
        output = subprocess.check_output(
            command,
            stderr=subprocess.STDOUT,
            shell=True
        )
    except Exception as e:
        output = str(e) + '\n'

    return output

while True:
    client, addr = server.accept()
    threading.Thread(target=shell, args=(client,)).start()
