#!/bin/bash
rm database.db
sqlite3 -init schema.sql database.db
