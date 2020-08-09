FROM docker

# Git, Java, Maven & pip

RUN apk update \
	&& apk add git openjdk8 maven py-pip \
	&& rm -rf /var/cache/apk/*

# AWS EB CLI

RUN pip install awsebcli --upgrade --user \
	&& ln -s ~/.local/bin/eb /usr/local/bin/eb