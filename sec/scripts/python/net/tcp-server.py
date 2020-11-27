import socket, threading

host = '0.0.0.0', 9998

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.bind(host)

sock.listen(5)

print 'Listening on %s' % (str(host))

def handle(client):
    request = client.recv(1024)

    print 'Received: %s' % (request,)

    client.send('ACK!!')
    client.close()

while True:
    client, addr = sock.accept()

    print 'Accepted connection from %s:%d' % (addr[0], addr[1])

    handler = threading.Thread(target=handle, args=(client,))
    handler.start()
