# Rästisovellus

### Mitä taskViewModel tekee?

Sovelluksessa taskViewModel hallitsee tilaa ja hoitaa UI-logiikan. Käytännössä se näkyy fetchPokemon-funktiossa, joka lähettää UI:sta käskyn tehdä API-kutsun/haun. Lisäksi se näkyy tehtävien merkkaamisena valmiiksi/keskeneräiseksi ja uuden  tehtävän luomisena.

### Miten Compose päivittyy, kun tila muuttuu?

Compose tarkastelee muutoksia taskViewModelissa, tarkasteltavat muutokset ovat uuden tehtävän luominen, tehtävän merkkaaminen valmiiksi/keskeneräiseksi ja API-kutsun suorittaminen.

### Mikä API-kutsu tehtiin?

Sovelluksessa käytettiin PokeAPI:a hakemaan pokemonia nimellä, API on opensource, joten avaimia tai tilejä ei tarvittu.

[Video](https://youtube.com/shorts/QCcs9PdwA7E)
