# RedHelix GitHub Repository
##Overview
RedHelix is a Java library and a server to monitor hardware using the DMTF Redfish specification. The RedHelix server uses the Redfish
specification to monitor multiple devices. It builds a in memory database representing the inventory and status of the devices and provides
a Restfull API to query the history of the devices.
## What is the difference between Redfish and RedHelix ?
Redfish provides the HTTP protocol and JSON messages to monitor a single server. RedHelix provides a database of multiple servers and the history for
each server. At present the database is only in limited to what is in memory and when the Java Virtual Machine shuts down all history is destroyed.
From a user perspective RedHelix will have a RESTful interface to the browser.
## Development Status
At present, September 2, 2015 there is no hardware implementing Redfish for sale or available to RedHelix for testing. If you have Redfish capable
hardware contact us. The current Java software
is tested with the DMTF Redfish mockup files. This prevents any development of Redfish operations that change the state of the server, for example
to reboot it.  
