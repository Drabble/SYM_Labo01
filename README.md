# SYM Labo 1

## 1. 
Comment organiser les textes pour obtenir une application multi-langues (français, allemand, italien, anglais, langue par défaut : anglais) ?

Dans le dossier values, il faut créer des fichiers xml contenant des strings en utilisant l'assistant de création et ajouter le qualifier "locale en choisissant la langue.
On peut créer autant de fichier qu'on veut pour chaque langue/région et même changer le texte en fonction de l'orientation de l'écran ou autre en utilisant les qualifiers.
Android va toujours choisir la traduction la plus spécifique possible pour l'appareil utilisé.
Le fichiers strings.xml est le fichier par défault et sera utilisé quand aucun autre language correspond. 

## 2. 
Dans l’exemple fourni, sur le dialogue pop-up, nous affichons l’icône android.R.drawable.ic_dialog_alert, disponible dans le SDK Android mais qui n’est pas très bien adaptée visuellement à notre utilisation. Nous souhaitons la remplacer avec notre propre image, veuillez indiquer comment procéder. Dans quel(s) dossier(s) devons-nous ajouter cette image ? 
Décrivez brièvement la logique derrière la gestion des ressources de type « image » sur Android. Info : Google met à disposition des icônes open source dans le style « Material Design » utilisé actuellement sur Android : https://design.google.com/icons/

Afin de modifier le logo de l'application, on commence par télécharger l'icone. On la place ensuite dans le dossier correspendant (drawable) du projet. Finalement, il faut ouvrir le fichier AndroidManifest.xml et changer la propriété android:icon de l'objet application (android:icon="@drawable/ic_info_black_24dp"). 

## 3. 
Lorsque le login est réussi, vous êtes censé chaîner une autre Activity en utilisant un Intent. Si je presse le bouton "Back" de l'interface Android, que puis-je constater ? Comment faire pour que l'application se comporte de manière plus logique ?

????????'

## 4. 
On pourrait imaginer une situation où cette seconde Activity fournit un résultat (par exemple l’IMEI ou une autre chaîne de caractères) que nous voudrions récupérer dans l'Activity de départ. Comment procéder ?

On peut set des propriétés de l'application en local.

## 5. 
Dans l’activité de login, en plaçant le téléphone (ou l’émulateur) en mode paysage (landscape), nous constatons que les 2 champs de saisie ainsi que le bouton s’étendent sur toute la largeur de l’écran. Veuillez réaliser un layout spécifique au mode paysage qui permet un affichage mieux adapté et indiquer comment faire pour qu’il soit utilisé à l’exécution. 
SYM – Systèmes mobiles Enseignant: Fabien Dutoit 5 / 5 
Assistant: Dominique Jollien


## 6. 
Le layout de l’interface utilisateur de l’activité de login qui vous a été fourni a été réalisé avec un LinearLayout à la racine. Nous vous demandons de réaliser un layout équivalent utilisant cette fois-ci un RelativeLayout.


## 7. 
Implémenter dans votre code les méthodes onCreate(), onStart(), onResume(), onPause(), onStop(), etc... qui marquent le cycle de vie d'une application Android, et tracez leur exécution. Décrivez brièvement à quelles occasions ces méthodes sont invoquées. Si vous aviez (par exemple) une connexion Bluetooth (ou des connexions bases de données, ou des capteurs activés) ouverte dans votre Activity, que faudrait-il peut-être faire, à votre avis (nous ne vous demandons pas de code ici) ?


## 8.
Facultatif, s’il vous reste du temps, nous vous conseillons de le consacrer à mettre en place la résolution
des permissions au runtime
