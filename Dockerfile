FROM	ubuntu

RUN 	rm /etc/apt/sources.list
RUN 	echo deb http://archive.ubuntu.com/ubuntu precise main universe multiverse > /etc/apt/sources.list

RUN 	apt-get update
RUN 	apt-get install openjdk-7-jre-headless -y
RUN 	apt-get install supervisor -y

RUN 	mkdir -p /var/log/supervisor

ADD 	supervisord.conf /etc/supervisor/conf.d/supervisord.conf

ADD 	./target/soap-stings.jar ./soap-stings.jar

CMD 	["/usr/bin/supervisord"]
