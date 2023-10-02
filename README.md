# Chess

1. [FR](#français)
2. [EN](#english)
3. [SCREENSHOTS](#screenshots)

# Français
Ce projet était à l'origine pour mon cours de développement. Je devais faire un jeu d'échecs basique en console. J'ai continué le projet pour y rajouter une vue JavaFX. 

## Comment sa fonctionne ?
Il suffit d'ouvrir le projet dans n'importe quel IDE ou console et de lancer `main.java`.

### Si vous utilisez NetBeans
Pour que tout fonctionne en console il y'a plusieurs étape :

1. il est conseilé d'utiliser un autre maven
pour avoir les couleurs dans l'output. Par exemple : apache-maven-3.3.9.<br>
Lien : https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/

2. Ajouter **-J-Dfile.encoding=UTF-8** à la propriété **netbeans_default_options** 
dans le fichier **etc/netbeans.conf** et relancer NetBeans.<br>
Lien : https://stackoverflow.com/questions/53257763/netbeans-9-print-unicode-characters

3. Optionnel. Vous pouvez aussi agrandir la taille de la police de l'output
pour une meilleur visibilité.

#  English
This project was originally for my development course. I had to make a basic chess game on console. I continued the project to add a JavaFX view.

## How it work ?

Just open the project in any IDE or console and run `main.java`.

### Netbeans users
To make everything work on console, there are several steps:

1. It is recommended to use a different Maven version to have colors in the output. For example: apache-maven-3.3.9.<br>
   Link: https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/

2. Add -J-Dfile.encoding=UTF-8 to the netbeans_default_options property in the etc/netbeans.conf file and restart NetBeans.<br>
   Link: https://stackoverflow.com/questions/53257763/netbeans-9-print-unicode-characters

3. Optional: You can also increase the font size of the output for better visibility.
    
# Screenshots
<img src="https://github.com/KBluelvl/Chess/blob/main/img/Menu.PNG" height="206"> <img src="https://github.com/KBluelvl/Chess/blob/main/img/Game.PNG" height="206">
<img src="https://github.com/KBluelvl/Chess/blob/main/img/Game2.PNG" height="206"><img src="https://github.com/KBluelvl/Chess/blob/main/img/Result.PNG" height="206">
