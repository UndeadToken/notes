import socket, os

host = '127.0.0.1', 53
log_dir = '/var/log/dns'

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind(host)

while True:
    data, addr = sock.recvfrom(512)
    ip = socket.gethostbyname(data)
    sock.sendto(ip, addr)

    path = '{}/{}.log'.format(log_dir, addr)
    mode = 'a'

    if not os.path.isfile(path):
        mode = 'w'

    with open(path, mode) as stream:
        stream.write('{} {}\n'.format(ip, data))

#http://solverbase.com/w/Windows_10:_Changing_DNS_Servers
#import os
#os.system('netsh interface ip set dns "Local Area Connection" static 192.168.0.200')
