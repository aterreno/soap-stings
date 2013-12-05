soap-stings
===========

## Stingray Riverbed Zeus SOAP API Via Json/Rest API powered by Clojure

### Stingray doesn't allow you to use the rest API when configured as multisite cluster

What to do? Circumvent the problem by bypassing the SOAP calls. 

Uses [lein-localrepo](https://github.com/kumarshantanu/) to get stingray pre-compiled api into your local maven repo. 

run:
`soap-build.sh` to get the StingRay Soap API generated (the clojure app needs it!).

run:
`lein localrepo coords ./out/Stingray-API.jar | xargs lein localrepo install`

to get the dependecies met (if you haven't run before localrepo you'll have to run this command twice)

See core.clj to see what's available (or handler.clj for the compojure routes) 

Comes with a Dockerfile, build with `docker-build.sh` and run it with `docker-run.sh`: tested on ubuntu. 

Comes with on [WTFPL](http://www.wtfpl.net/) licence, it's just a spike and a sort of note on how to do some weird interop things with Java/SOAP services. All the stuff generated or that comes from riverbed / zeus is under their property/licencing. 

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY: if it kills your Zeus it's not my problem!


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/aterreno/soap-stings/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

