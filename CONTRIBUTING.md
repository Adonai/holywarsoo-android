How to contribute
-----------------

Patches and third-party assistance are essential for this project. I don't have lots of time
and simply can't afford testing on specific platforms like Android Oreo or old ones like 5.0.1.
I'll try to keep process of submitting changes as easy as possible, not requiring anything above the usual
chaos, heresy and mayhem.

Prerequisites
-------------

* Make sure you have [GitLab account](https://gitlab.com/users/sign_in#register-pane)

* Submit an [issue](https://gitlab.com/Kanedias/holywarsoo-android/issues/new?issue) for your change. This step is not required, but I highly recommend it.
  While this can seem redundant, there were numerous situations I hated myself for not
  doing it. This can be anything: the author of the project can reject patch for not
  following specific code guidelines that you never saw mentioned, or this can be scripts,
  tests and lint warnings that you must deal with, or even dead-simple - you can be just
  unfortunate for submitting your patch prior to big API change or version bump.
  So... just ask, if you need anything.

* [Fork](https://gitlab.com/Kanedias/holywarsoo-android/forks/new) the repository on GitLab

* Create a feature branch from `master` branch in Holywarsoo main repo. Avoid working
  directly on `master` branch - conflicts may arise, you won't be able to update,
  I may `force push` commits while thinking nobody sees it... etc.

* Commit your changes. If you want to be very good person in your earthly life,
  do it as Linux kernel contributing guide commands - first line is short
  description, second is empty, third and all rest - full description of
  changes. Use issue you created previously in the first line as with hash sign
  for GitHub to be able to link them together. You never know when this may be
  useful. Like this: `Implement basic UI. Fixes #1`

* Create a merge-request from your fork against the main Holywarsoo repo. Wait for
  smoke-build to finish and make sure it passes. Then it's my turn, I'll keep an eye
  on merge-requests and check them on a regular basis. After some bouncing back and
  forth around my nitpicking style it will get merged and we all can sleep happily

* Great, welcome to the club!

What you may wanted to see here but nope
--------------------------------------

* There are no tests atm, I plan on adding them.

* There are no strict coding guidelines for now. I personally tend to Android+Kotlin style
  and eventually will refactor everything along with adding proper CI style check
  but now you are free to submit changes with whatever style you wish.

* I won't punish or disgrace you if your change breaks something. One cannot
  possibly [know](https://lkml.org/lkml/2004/12/20/255) [everything](http://catb.org/esr/writings/unix-koans/zealot.html). This project is very niche and every
  contribution values.


