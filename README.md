soap-stings
===========

# Spiking out Stingray Riverbed Zeus SOAP API

Uses [lein-localrepo](https://github.com/kumarshantanu/) to get stingray pre-compiled api into your local maven repo. 

run:
`lein localrepo coords ./obj/stingray-1.2.jar | xargs lein localrepo install`

to get the dependecies met

See main.clj if you really dare using it on the command line

See core.clj to see what's available. 

Comes with on [WTFPL](http://www.wtfpl.net/) licence, it's just a spike and a sort of note on how to do some weird interop things with Java/SOAP services. All the stuff generated or that comes from riverbed / zeus is under their property/licencing. 

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY: if it kills your Zeus it's not my problem!

>>>>>>> init commit
