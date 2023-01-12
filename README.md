# Projet_Auto_Battler

~ Emilien HEMERY, Bilal ESSAYED MESSOUADI, Baptiste FOSSET et Mael GUILLAS ~

Voici le mode d'emploi de notre projet d'Auto Battler.

Tout d'abord, vous pouvez exécuter notre fichier .jar dans un terminal de commande Windows
avec la commande java -jar ProjetAutoBattler.jar 

Ensuite, vous arriverez sur la page d'accueil permettant de changer le nom des joueurs
et de lancer la partie.

La partie commence avec la phase de préparation où vous pouvez effectuer différentes actions
à l'aide de commandes : buy suivi de 0, 1 ou 2 permet de choisir le battler du shop
que vous souhaitez acheter, sell suivi d'un chiffre entre 0 et 9 permet de choisir 
le battler que vous souhaitez vendre, up permet d'améliorer votre shop contre des golds, 
refresh permet d'avoir un nouveau trio de battler dans votre shop (1 fois par tour), 
done permet de mettre fin à la phase de préparation et help affiche l'aide des commandes.

Après quoi commence la phase de placement, vous pouvez choisir dans vos battlers ceux qui 
participeront à la bataille en écrivant un chiffre de 0-9 correspondant à leur position 
dans votre main. Attention ! Choisir un battler décale de position tous les battlers situés 
après lui dans votre main. La phase de placement se termine lorsque les 4 emplacements 
sont remplis ou lorsque le joueur tape "done".

Enfin, la bataille ! Les battlers vont aléatoirement attaquer un battler adverse, 
lui infliger ses dégâts et recevoir les dégâts adverses. Lorsque les points de vie d'un battler
atteigne 0, il meurt... Lorsqu'un des 2 joueurs n'a plus de battlers sur le champ de bataille, 
il perd la bataille et subit des dégâts égaux à la somme des rangs des battlers encore en vie.
La partie se termine lorsque l'un des 2 joueurs n'a plus de points de vie.