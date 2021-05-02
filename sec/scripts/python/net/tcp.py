import socket

host = '0.0.0.0', 9998

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect(host)

sock.send('GET / HTTP/1.1\r\nHost: google.com\r\n\r\n')
response = sock.recv(4096)

sock.close()

print response
