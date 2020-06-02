#!/bin/sh

java  -Dkarate.config.dir=src/test/java -jar ../karate-0.9.4.jar --threads=3 src/test/resources/feature/success
