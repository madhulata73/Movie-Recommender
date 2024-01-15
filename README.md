# Movie-Recommender


INSERT INTO `movie`.`language` (`id`, `name`) VALUES ('1', 'English');
INSERT INTO `movie`.`language` (`id`, `name`) VALUES ('2', 'Hindi');
INSERT INTO `movie`.`language` (`id`, `name`) VALUES ('3', 'Marathi');
INSERT INTO `movie`.`language` (`id`, `name`) VALUES ('4', 'Tamil');
INSERT INTO `movie`.`language` (`id`, `name`) VALUES ('5', 'Kannadda');
INSERT INTO `movie`.`language` (`id`, `name`) VALUES ('6', 'Telugu');
INSERT INTO `movie`.`language` (`id`, `name`) VALUES ('7', 'Begali');
INSERT INTO `movie`.`language` (`id`, `name`) VALUES ('8', 'Punjabi');
INSERT INTO `movie`.`language` (`id`, `name`) VALUES ('9', 'Malyalam');



INSERT INTO `movie`.`genres` (`id`, `name`) VALUES ('1', 'Drama');
INSERT INTO `movie`.`genres` (`id`, `name`) VALUES ('2', 'Comedy');
INSERT INTO `movie`.`genres` (`id`, `name`) VALUES ('3', 'Action');
INSERT INTO `movie`.`genres` (`id`, `name`) VALUES ('4', 'Horror');
INSERT INTO `movie`.`genres` (`id`, `name`) VALUES ('5', 'Biography');
INSERT INTO `movie`.`genres` (`id`, `name`) VALUES ('6', 'Thriller');
INSERT INTO `movie`.`genres` (`id`, `name`) VALUES ('7', 'Romance');
INSERT INTO `movie`.`genres` (`id`, `name`) VALUES ('8', 'Crime');
INSERT INTO `movie`.`genres` (`id`, `name`) VALUES ('9', 'Sci-Friction');


INSERT INTO `movie`.`actors` (`id`, `is_director`, `name`) VALUES ('1', b'0', 'Actor1');
INSERT INTO `movie`.`actors` (`id`, `is_director`, `name`) VALUES ('2', b'0', 'Actor2');
INSERT INTO `movie`.`actors` (`id`, `is_director`, `name`) VALUES ('3', b'0', 'Actor3');
INSERT INTO `movie`.`actors` (`id`, `is_director`, `name`) VALUES ('4', b'1', 'Director1');
INSERT INTO `movie`.`actors` (`id`, `is_director`, `name`) VALUES ('5', b'0', 'Actor4');

INSERT INTO `movie`.`movies` (`id`, `description`, `title`, `no_of_likes`, `average_rating`) VALUES ('1', 'A crime drama directed by Martin Scorsese and starring Leonardo DiCaprio and Robert De Niro', 'Killers of the Flower Moon', '300', '4.5');
INSERT INTO `movie`.`movies` (`id`, `description`, `title`, `no_of_likes`, `average_rating`) VALUES ('2', 'The Ballad of Songbirds and Snakes: A science fiction adventure film directed by Francis Lawrence', 'The Hunger Games', '300', '4');
INSERT INTO `movie`.`movies` (`id`, `description`, `title`, `no_of_likes`, `average_rating`) VALUES ('3', 'A horror film based on the video game series of the same name','Five Nights at Freddy’s', '300', '3.5');
INSERT INTO `movie`.`movies` (`id`, `description`, `title`, `no_of_likes`, `average_rating`) VALUES ('4', 'A biographical drama film about Napoleon Bonaparte directed by Ridley Scott','Napoleon',  '300', '4');
INSERT INTO `movie`.`movies` (`id`, `description`, `title`, `no_of_likes`, `average_rating`) VALUES ('5', ' A superhero film directed by Nia DaCosta and starring Brie Larson, Iman Vellani, and Teyonah Parris','The Marvels', '300', '5');
INSERT INTO `movie`.`movies` (`id`, `description`, `title`, `no_of_likes`, `average_rating`) VALUES ('16', 'A biographical drama film about Napoleon Bonaparte directed by Ridley Scott','Napoleon',  '300', '4');
INSERT INTO `movie`.`movies` (`id`, `description`, `title`, `no_of_likes`, `average_rating`) VALUES ('17', ' A superhero film directed by Nia DaCosta and starring Brie Larson, Iman Vellani, and Teyonah Parris','The Marvels',  '300', '5');


INSERT INTO movie.movie_genres(`movie_id`, `genres_id`) VALUES ('1', '8');
INSERT INTO movie.movie_genres(`movie_id`, `genres_id`) VALUES ('2', '9');
INSERT INTO movie.movie_genres(`movie_id`, `genres_id`) VALUES ('3', '4');
INSERT INTO movie.movie_genres(`movie_id`, `genres_id`) VALUES ('4', '5');
INSERT INTO movie.movie_genres(`movie_id`, `genres_id`) VALUES ('5', '3');

INSERT INTO movie.movies_actors(`movies_id`, `actors_id`) VALUES ('1', '2');
INSERT INTO movie.movies_actors(`movies_id`, `actors_id`) VALUES ('1', '4');
INSERT INTO movie.movies_actors(`movies_id`, `actors_id`) VALUES ('2', '3');
INSERT INTO movie.movies_actors(`movies_id`, `actors_id`) VALUES ('2', '4');
INSERT INTO movie.movies_actors(`movies_id`, `actors_id`) VALUES ('3', '1');
INSERT INTO movie.movies_actors(`movies_id`, `actors_id`) VALUES ('3', '4');
INSERT INTO movie.movies_actors(`movies_id`, `actors_id`) VALUES ('4', '5');
INSERT INTO movie.movies_actors(`movies_id`, `actors_id`) VALUES ('4', '4');
INSERT INTO movie.movies_actors(`movies_id`, `actors_id`) VALUES ('5', '1');
INSERT INTO movie.movies_actors(`movies_id`, `actors_id`) VALUES ('5', '4');


INSERT INTO movie.movie_language(`movie_id`, `language_id`) VALUES ('1', '1');
INSERT INTO movie.movie_language(`movie_id`, `language_id`) VALUES ('1', '2');
INSERT INTO movie.movie_language(`movie_id`, `language_id`) VALUES ('1', '3');
INSERT INTO movie.movie_language(`movie_id`, `language_id`) VALUES ('2', '3');
INSERT INTO movie.movie_language(`movie_id`, `language_id`) VALUES ('2', '4');
INSERT INTO movie.movie_language(`movie_id`, `language_id`) VALUES ('3', '5');
INSERT INTO movie.movie_language(`movie_id`, `language_id`) VALUES ('3', '6');
INSERT INTO movie.movie_language(`movie_id`, `language_id`) VALUES ('4', '1');
INSERT INTO movie.movie_language(`movie_id`, `language_id`) VALUES ('4', '9');
INSERT INTO movie.movie_language(`movie_id`, `language_id`) VALUES ('5', '1');




