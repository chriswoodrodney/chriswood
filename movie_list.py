"""
Name:OKWIIRI CHRISWOOD RODNEY
Date started:13/03/24
GitHub URL (of this assignment):
Remember to NEVER make this assignment repo public
"""
import csv
import os

# Constants
MOVIES_FILE = "movies.csv"
UNWATCHED = "u"
WATCHED = "w"


def load_movies():
    """Load movies from CSV file."""
    movies = []
    try:
        with open(MOVIES_FILE, "r") as file:
            reader = csv.reader(file)
            for row in reader:
                movies.append(row)
        print(f"{len(movies)} movies loaded")
    except FileNotFoundError:
        print("No movies file found. Starting with an empty list.")
    return movies