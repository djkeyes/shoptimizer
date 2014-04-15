# Readme

## Shoptimizer!
----
This app aims to answer a simple question: given the name of a good from a grocery store, what is the cheapest version of it available? The answer to this question is sometimes difficult, as some goods have multiple names or are sold by competing brands, and many goods are distributed in different storage states (fresh, frozen, dried). Sometimes users may want a particular brand or feature, and other times they may want to consider similar goods as a replacement.

To answer this question, we present the Shoptimizer app. Optimize your grocery shopping! Shoptimize it!

## Development
----
This was started at Emory University's 2014 Hackathon. It is implemented as a Play2 web app in Java and Scala, using Typesafe's Activator. See [their website](http://www.playframework.com/) for documentation and build instructions. Like other Activator based apps, this code incudes an activator and activator.bat script for local deployment, which can be run in a bash shell with:
```
activator ui
```
or on Windows with:
```
activator.bat ui
```
Similarly, it can be exported and built and run from Eclipse or Netbeans--the user-specific project files are listed in .gitignore and are excluded from this repository. See the Play documentation for doing so.

