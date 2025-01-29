| ligne exécutée           | effet                                                      | pile d'appels |
|--------------------------|------------------------------------------------------------|---------------|
| super.onCreate(savedInstanceState)                    |  override la méthode onCreate de AppCompatActivity() indiquant d'exécuter le code de la méthode additionnel au code de la page                                                  | __onCreate__      |
| binding = ActivityMainBinding.inflate(layoutInflater)                    | Crée une instance de ActivityMainBinding sous le nom de binding pour facilité la recherche des éléments                                    | __onCreate__       |
| setContentView(binding.root) | Indique à Android quoi afficher, quelle activité avec le fichier xml       | __onCreate__       |
| Toast.makeText(this, "N", Toast.LENGTH_SHORT).show()            | Crée un popup avec la lettre N     |  __onCreate__  |
| actionBouton()                | Lance la méthode actionBouton()                   | __onCreate__  |
| Toast.makeText(this, "O", Toast.LENGTH_SHORT).show() | Crée un popup avec la lettre O | __actionBouton__ <br /> onCreate      |
| binding.bouton.setOnClickListener                | Initialise l'action ou les actions lorsque le bouton est cliqué  | __actionBouton__ <br /> onCreate |
| Toast.makeText(this, "Ë", Toast.LENGTH_SHORT).show() | Crée un popup avec la lettre Ë    | __actionBouton__ <br /> onCreate     |
| Toast.makeText(this, "L", Toast.LENGTH_SHORT).show() | Crée un popup avec la lettre L    |  __onCreate__     |
| Toast.makeText(this, "H", Toast.LENGTH_SHORT).show() | Crée un popup avec la lettre H| __onclick__  <br /> onCreate |
| Toast.makeText(this, "O", Toast.LENGTH_SHORT).show() |  Crée un popup avec la lettre O| __onclick__ <br /> onCreate     |
| Toast.makeText(this, "H", Toast.LENGTH_SHORT).show() | Crée un popup avec la lettre H| __onclick__ <br /> onCreate |
| Toast.makeText(this, "O", Toast.LENGTH_SHORT).show() | Crée un popup avec la lettre O| __onclick__ <br /> onCreate     |
