CREATE TABLE "player" (
	"id" serial NOT NULL,
	"nickname" varchar(64) NOT NULL,
	"country_id" integer NOT NULL,
	"registrated" TIMESTAMP NOT NULL,
	"club_id" integer,
	"games_played" integer,
	"birth_date" TIMESTAMP NOT NULL,
	"email" varchar NOT NULL UNIQUE,
	"password" varchar(64) NOT NULL,
	"elo_points" integer NOT NULL,
	"rank" varchar NOT NULL,
	CONSTRAINT "player_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "game" (
	"id" serial NOT NULL,
	"white_player_id" integer NOT NULL,
	"black_player_id" integer NOT NULL,
	"tournament_id" integer,
	"winner_id" integer,
	"loser_id" integer,
	"started" TIMESTAMP NOT NULL,
	"ended" TIMESTAMP,
	"mode" varchar NOT NULL,
	CONSTRAINT "game_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "move" (
	"id" serial NOT NULL,
	"game_id" integer NOT NULL,
	"player_id" integer NOT NULL,
	"piece" varchar NOT NULL,
	"move_notation_from" varchar(2) NOT NULL,
	"move_notation_to" varchar(2) NOT NULL,
	"move_time" integer NOT NULL,
	CONSTRAINT "move_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "tournament" (
	"id" serial NOT NULL,
	"name" varchar NOT NULL UNIQUE,
	"started" TIMESTAMP NOT NULL,
	"ended" TIMESTAMP,
	"country_id" integer,
	"winner_id" integer,
	CONSTRAINT "tournament_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "country" (
	"id" serial NOT NULL,
	"name" varchar NOT NULL UNIQUE,
	CONSTRAINT "country_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "player_tournament_participation" (
	"id" serial NOT NULL,
	"player_id" integer NOT NULL,
	"tournament_id" integer NOT NULL,
	"tournament_points" integer NOT NULL,
	CONSTRAINT "player_tournament_participation_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "message" (
	"id" serial NOT NULL,
	"writer_id" integer NOT NULL,
	"content" varchar NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"game_id" integer NOT NULL,
	CONSTRAINT "message_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "club" (
	"id" serial NOT NULL,
	"name" varchar NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"deleted" TIMESTAMP,
	"number_of_members" integer NOT NULL,
	"country_id" integer,
	CONSTRAINT "club_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "board" (
	"id" serial NOT NULL,
	"game_id" integer NOT NULL,
	"piece" varchar NOT NULL,
	"position_letter" varchar(1) NOT NULL,
	"position_number" integer NOT NULL,
	CONSTRAINT "board_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "player" ADD CONSTRAINT "player_fk0" FOREIGN KEY ("country_id") REFERENCES "country"("id");
ALTER TABLE "player" ADD CONSTRAINT "player_fk1" FOREIGN KEY ("club_id") REFERENCES "club"("id");

ALTER TABLE "game" ADD CONSTRAINT "game_fk0" FOREIGN KEY ("white_player_id") REFERENCES "player"("id");
ALTER TABLE "game" ADD CONSTRAINT "game_fk1" FOREIGN KEY ("black_player_id") REFERENCES "player"("id");
ALTER TABLE "game" ADD CONSTRAINT "game_fk2" FOREIGN KEY ("tournament_id") REFERENCES "tournament"("id");
ALTER TABLE "game" ADD CONSTRAINT "game_fk3" FOREIGN KEY ("winner_id") REFERENCES "player"("id");
ALTER TABLE "game" ADD CONSTRAINT "game_fk4" FOREIGN KEY ("loser_id") REFERENCES "player"("id");

ALTER TABLE "move" ADD CONSTRAINT "move_fk0" FOREIGN KEY ("game_id") REFERENCES "game"("id");
ALTER TABLE "move" ADD CONSTRAINT "move_fk1" FOREIGN KEY ("player_id") REFERENCES "player"("id");

ALTER TABLE "tournament" ADD CONSTRAINT "tournament_fk0" FOREIGN KEY ("country_id") REFERENCES "country"("id");
ALTER TABLE "tournament" ADD CONSTRAINT "tournament_fk1" FOREIGN KEY ("winner_id") REFERENCES "player"("id");


ALTER TABLE "player_tournament_participation" ADD CONSTRAINT "player_tournament_participation_fk0" FOREIGN KEY ("player_id") REFERENCES "player"("id");
ALTER TABLE "player_tournament_participation" ADD CONSTRAINT "player_tournament_participation_fk1" FOREIGN KEY ("tournament_id") REFERENCES "tournament"("id");

ALTER TABLE "message" ADD CONSTRAINT "message_fk0" FOREIGN KEY ("writer_id") REFERENCES "player"("id");
ALTER TABLE "message" ADD CONSTRAINT "message_fk1" FOREIGN KEY ("game_id") REFERENCES "game"("id");

ALTER TABLE "club" ADD CONSTRAINT "club_fk0" FOREIGN KEY ("country_id") REFERENCES "country"("id");

ALTER TABLE "board" ADD CONSTRAINT "board_fk0" FOREIGN KEY ("game_id") REFERENCES "game"("id");
