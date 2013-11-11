#!/bin/bash

lein uberjar
docker build -t soap-stings .