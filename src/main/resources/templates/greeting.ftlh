<@layout title="Greet">
	<div id="greeting">Hello World</div>
	<input id="name" name="value" type="text" />
	<button hx-post="/greet" hx-target="#greeting" hx-include="#name">Greet</button>
</@layout>