Pour que tout fonctionne il y'a plusieurs étape :

1. il est conseilé (si vous utilisez NetBeans) d'utiliser un autre maven
pour avoir les couleurs dans l'output. Par exemple : apache-maven-3.3.9.<br>
Lien : https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/

2. Ajouter **-J-Dfile.encoding=UTF-8** à la propriété **netbeans_default_options** 
dans le fichier **etc/netbeans.conf** et relancer NetBeans.<br>
Lien : https://stackoverflow.com/questions/53257763/netbeans-9-print-unicode-characters

3. Optionnel. Vous pouvez aussi agrandir la taille de la police de l'output
pour une meilleur visibilité.
