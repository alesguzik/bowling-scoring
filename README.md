# bowling-scoring

A Clojure library for working with bowling scorecards.

## Usage

Public api consists of 4 functions in the `bowling-scoring.core` namespace:

* `(make-score-card)` - returns an empty scorecard
* `(add-frame score-card frame)` — returns updated scorecard with a new frame
* `(complete-game? score-card)` — returns true if the game is complete and ready for scoring
* `(calculate-score score-card)` — returns the score of the scorecard

## License

Copyright © 2019 Ales Huzik

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
