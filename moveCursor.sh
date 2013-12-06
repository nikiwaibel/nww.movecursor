#! /bin/sh

# movecursor - an attempt to prevent the screenlock
# Copyright (C) 2011, 2013  Niki W. Waibel
# This file is part of movecursor.
#
# movecursor is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# movecursor is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with movecursor.  If not, see <http://www.gnu.org/licenses/>.

DIRNAME=`dirname "$0"`
exec java -cp "$DIRNAME" MoveCursor
