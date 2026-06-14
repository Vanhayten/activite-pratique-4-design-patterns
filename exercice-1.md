# Exercice 1 : Modélisation et Design Patterns

## Situation 1
**Description** : Une figure peut être soit un cercle, un rectangle ou un groupe de figures.
**Design Pattern Appliqué** : **Composite**
**Justification** : Le pattern Composite permet de traiter un groupe d'objets de la même manière qu'un objet individuel. Ici, `GroupeFigures` (Composite) et les figures de base `Cercle`/`Rectangle` (Leaves) implémenteront tous la même interface ou hériteront de la même classe abstraite `Figure` (Component).

## Situation 2
**Description** : Un plugin contient une opération implémentant le squelette d’un algorithme dont deux parties sont variables, et l'instanciation de l'implémentation doit se faire sans connaitre sa classe.
**Design Patterns Appliqués** : **Template Method** & **Factory Method**
**Justification** : 
- **Template Method** : Définit le squelette de l'algorithme dans une classe abstraite (`PluginBase`) et délègue l'implémentation des étapes variables (`partie1()` et `partie2()`) aux sous-classes concrètes.
- **Factory Method** (ou Abstract Factory) : Fournit une méthode permettant de créer des instances de plugins concrets sans que le code client ne soit couplé aux classes spécifiques.

## Situation 3
**Description** : Envelopper l’exécution de la méthode `traitement()` par d’autres traitements avant et après son exécution sans modifier son code source.
**Design Pattern Appliqué** : **Decorator** (ou Proxy)
**Justification** : Le pattern Decorator permet d'ajouter des responsabilités supplémentaires (traitements avant/après) à un objet dynamiquement. Le décorateur implémente la même interface que le composant, encapsule une instance de ce composant, et redéfinit `traitement()` en ajoutant le nouveau comportement.

## Situation 4
**Description** : Notification des objets de l'environnement (Couloir, Caméra, Gardien) lorsque le score du Joueur change, avec un couplage faible.
**Design Pattern Appliqué** : **Observer**
**Justification** : Le pattern Observer définit une relation de dépendance "un-à-plusieurs" entre des objets. Ici, `Joueur` est le Sujet (Observable) et maintient une liste d'observateurs. `Couloir`, `Caméra` et `Gardien` sont des Observateurs qui s'enregistrent auprès du Sujet pour être notifiés à chaque changement de l'état `score`.
