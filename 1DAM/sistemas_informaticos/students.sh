#! /bin/bash

ALUMNOS=$( cat alumnos.txt )

sudo mkdir /home/alumnos

sudo groupadd "alumnos"

sudo chgrp alumnos /home/alumnos

sudo chmod 770 /home/alumnos

for ALUMNO in $ALUMNOS
do
	sudo useradd -g "alumnos" $ALUMNO
done


