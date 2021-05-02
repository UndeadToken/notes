import socket

host = '127.0.0.1', 1024

sock = socket.socket(AF_INET, socket.SOCK_DGRAM)

payload = 'AAABBBCCC'
sock.sendto(payload, host)

data, addr = sock.recvfrom(4096)

print data
