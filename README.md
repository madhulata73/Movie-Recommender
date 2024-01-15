 Each movie has a title, description, film director, list of actors, and image(s) from the main playbill. 
 
 movie table--id, title, desc, dir, actors
 Actor table- id,name 
 movie_actor--movie_id,_actor_id
 
 
 Playbill -  movie_image, movie id.
 Genres - genres id, genres_name
 movie_genres= movie_id, genres_id
 
 
 
 Each movie is categorized into one or more genres. 
 Only the administrator can create, remove and update the list of movies. 
 Users can rate the movies according to different criteria (e.g, how novel are the ideas of the movie, their final score, etc.). 
 
The main feature of the system is that users can pick one movie and get the list of similar movies and/or movies that were liked the most by other users watching the same movie (no need for complex algorithms, some simple recommendation is enough!).