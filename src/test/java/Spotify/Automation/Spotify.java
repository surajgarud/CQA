package Spotify.Automation;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Spotify {
	
	public String Token ="Bearer BQAlMVYyv3preMOtT4a84PIEFQElulNnpdnNoRr8Wy2qEuLcBvkgfeJx8MMxC82_wp11Q"
			+ "VapsIrieVhAQr77SIn8ojehquMZiJ10wcSAzcpJypk2q6UhX0vY3E_XKSw0_fpFGCVXtnYK2yGw34eY1KeuIYtfW2tQXT74SNgERZzO2pG"
			+ "6zm72eZFF8VtAvawCe0Fk3VK00zLukCGYWsVNF1oMynxrUtVi5IR7rV9yXnaHbP0Da8-yHOoGw6P2YkEJ-lznD748y_0";
	public String UserId;
	public String TrackId;
	public String PlayId;
	public String ShowsId;
	public String ArtistId;
	public String AlbumId;

	@Test(priority=3)
	public void GetCurrentUsersProfile() {
		Response res = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/me" );
		res.prettyPrint();
		res.then().statusCode(200);
		Assert.assertEquals(res.statusCode(),200);
		String name = res.path("external_urls.spotify");
		UserId = res.path("id");
		System.out.println(name);
		System.out.println(UserId);
	}
	@Test
	public void GetUsersProfile() {
		Response res = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/users/"+UserId+"");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
							// TRACK	
	@Test(priority=1)
	public void GetTrack() {
		Response res = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl");
		res.prettyPrint();
		TrackId = res.path("id");
	System.out.println(TrackId);
	Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetSeveralTracks() {
		Response res = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/tracks?ids=%227ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test(priority=2)
	public void GetTracksAudioFeatures() {
		Response res = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/audio-features/"+ TrackId +"");
		res.prettyPrint();
	}
	@Test
	public void GetTracksAudioFeaturesl() {
		Response res = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/audio-features?ids=%227ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test(priority=3)
	public void GetTracksAudioAnalysis() {
		Response res = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/audio-analysis/"+ TrackId +"");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
											//Search
	@Test
	public void SearchforItem() {
		Response res = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.pathParam("q", "artist")
				.pathParam("type", "track")
				.when()
				.get("https://api.spotify.com/v1/search?q={q}&type={type}");
		res.prettyPrint();
		
		String ID = res.path("id");
		System.out.println(ID);
		Assert.assertEquals(res.statusCode(),200);
	}
										//Playlist
	@Test(priority=4)
	public void CreatePlaylist() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.body("{\"name\":\"New Playlist\",\"description\":\"New playlist description\",\"public\":false}")
				.when()
				.post("https://api.spotify.com/v1/users/"+UserId+"/playlists");
		res.prettyPrint();
		PlayId = res.path("id");
		System.out.println(PlayId);
		Assert.assertEquals(res.statusCode(),201);
	}
	@Test(priority=5)
	public void AddItemstoPlaylist() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.body("{\"uris\":[\"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\",\"spotify:track:1301WleyT98MSxVHPZCA6M\",\"spotify:episode:512ojhOuo1ktJprKbVcKyQ\"]}")
				.when()
				.post("https://api.spotify.com/v1/playlists/"+PlayId+"/tracks");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),201);
	}
	@Test(priority=6)
	public void GetUsersPlaylists() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/users/"+UserId+"/playlists");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test(priority=7)
	public void GetPlaylist() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/playlists/"+PlayId+"");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}	
	@Test(priority=8)
	public void GetPlaylistItems() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/playlists/"+PlayId+"/tracks");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test(priority=9)
	public void GetPlaylistCoverImage() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/playlists/"+PlayId+"/images");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetCurrentUsersPlaylists() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/me/playlists");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}	
	@Test(priority=10)
	public void RemovePlaylistItems() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.body("{\"tracks\":[{\"uri\":\"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\"},{\"uri\":\"spotify:track:1301WleyT98MSxVHPZCA6M\"}]}")
				.when()
				.delete("https://api.spotify.com/v1/playlists/"+PlayId+"/tracks");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}	
	@Test(priority=11)
	public void ChangePlaylistDetails() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.body("{\"name\":\"Updated Playlist Name16\",\"description\":\"Updated playlist description\",\"public\":false}")
				.when()
				.put("https://api.spotify.com/v1/playlists/"+ PlayId+"");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test(priority=12)
	public void UpdatePlaylistItems() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.body("{\"range_start\":1,\"insert_before\":3,\"range_length\":2}")
				.when()
				.put("https://api.spotify.com/v1/playlists/"+PlayId+"/tracks");
		res.prettyPrint();
	}	
	@Test(priority=13)
	public void AddCustomPlaylistCoverImage() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.put("https://api.spotify.com/v1/playlists/"+PlayId+"/images");
		res.prettyPrint();
	}	
									//Shows
	@Test(priority=14)
	public void GetShow() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ");
		res.prettyPrint();
		ShowsId = res.path("id");
		System.out.println(ShowsId);
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test(priority=15)
	public void GetShowEpisodes() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/shows/"+ShowsId+"/episodes");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test()
	public void GetSeveralShows() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/shows?ids=5CfCWKI5pZ28U0uOzXkDHe");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
										//Personalization
	@Test
	public void GetUsersTopItems() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.pathParam("type","artist")
				.when()
				.get("https://api.spotify.com/v1/me/top/{type}");
		res.prettyPrint();
		
	}
										//Markets
	@Test
	public void GetAvailableMarkets() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/markets");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
										//Episodes
	@Test
	public void GetEpisode() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetSeveralEpisodes() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
										//Chapters
	@Test(priority=16)
	public void GetaChapter() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/chapters/"+ShowsId+"");
		res.prettyPrint();
		
	}
	@Test
	public void GetSeveralChapters() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/chapters?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
										//Audiobooks
	@Test
	public void AGetSeveralAudiobooks() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}									
										//Artist
	@Test(priority=17)
	public void GetArtist() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
		res.prettyPrint();
		ArtistId = res.path("id");
		System.out.println(ArtistId);
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test(priority=18)
	public void GetArtistsTopTracks() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/artists/"+ArtistId);
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test(priority=19)
	public void GetArtistsRelatedArtists() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/artists/"+ArtistId+"/related-artists");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test(priority=20)
	public void GetArtistsAlbums() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/artists/"+ArtistId+"/albums");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
									//Albums
	@Test(priority=21)
	public void GetAlbum() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
		AlbumId = res.path("id");
		System.out.println(AlbumId);
	}
	@Test(priority=22)
	public void GetAlbumTracks() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/albums/"+AlbumId+"/tracks");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetSeveralAlbums() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetSeveralArtists() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
										//Browse
	@Test
	public void GetAvailableGenreSeeds() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetSeveralBrowseCategories() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/browse/categories");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetSingleBrowseCategory() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.pathParam("category_id","dinner")
				.when()
				.get("https://api.spotify.com/v1/browse/categories/{category_id}");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetCategorysPlaylists() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.pathParam("category_id","dinner")
				.when()
				.get("https://api.spotify.com/v1/browse/categories/{category_id}/playlists");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetFeaturedPlaylists() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/browse/featured-playlists");
		Assert.assertEquals(res.statusCode(),200);
		res.prettyPrint();	
	}
	@Test
	public void GetNewReleases() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/browse/new-releases");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetRecommendations() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.pathParam("seed_artists", "4NHQUGzhtTLFvgF5SZesLK")
				.pathParam("seed_genres", "country")
				.pathParam("seed_tracks", "0c6xIDDpzE81m2q797ordA")
				.when()
				.get("https://api.spotify.com/v1/recommendations?seed_artists={seed_artists}&seed_genres={seed_genres}&seed_tracks={seed_tracks}");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
									//Follow
	
	@Test
	public void GetFollowedArtists() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.pathParam("type", "artist")
				.when()
				.get("https://api.spotify.com/v1/me/following?type={type}");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void CheckIfUserFollowsArtistsorUsers() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.pathParam("type", "artist")
				.when()
				.get("https://api.spotify.com/v1/me/following/contains?type={type}&ids=2CIMQHirSU0MQqyYHq0eOx");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}	
	@Test
	public void UnfollowArtistsorUsers() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.pathParam("type", "artist")
				.when()
				.delete("https://api.spotify.com/v1/me/following?type={type}&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
		res.prettyPrint();
	
	}
										//Player
	@Test
	public void GetAvailableDevices() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/me/player/devices");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
	}
	@Test
	public void GetCurrentlyPlayingTrack() {
		Response res = given()
				.header("Accept","application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", Token)
				.when()
				.get("https://api.spotify.com/v1/me/player/currently-playing");
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),204);
	}
}
