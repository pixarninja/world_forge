# Sprite Renderer for Android Studio

This repository contains a simple implementation of a "sprite renderer" for Android Studio. Android Studio does not provide it's users with any innate sprite rendering/animation capabilities; it allows users to use the Bitmap, SurfaceView, and ImageView classes, however there is no package that contains a complete way to use spritesheets. This project is intended to provide users with that ability.

# What Is "Sprite Rendering"?

The term "sprite rendering" refers to the use of spritesheets in order to implement animations. An example of a spritesheet from this repositoy is shown below.

![Spritesheet](/app/src/main/res/mipmap-xxxhdpi/spritesheet_box_rotate_up_red_mirror.png)

If you would like to make a game or app that uses this form of spritesheet, clone this repository and start by editing the sample game provided for you. Don't forget to rename the package directories, and update the new package name inside of the manifest. For help on creating a game, descriptions of each class and its methods can be found below.

# The Sample Game

![SampleGame](/source/Photoshop/sample_game_description.png)

# Class Definitions

## SpriteController

SpriteController is the object that holds a sprite's position, entity, and frame rate variables. The role of the SpriteController is to manage which spritesheet is shown for each sprite; sprites are able to change the spritesheet displayed through transitions, and in order to save memory only one SpriteEntity object is created per controller. Thus, the controller stores the entity currently being displayed on the screen, and also keeps track of the position and frame rate for the sprites it manages.

### void makeTransition(...)

Parameters: *String ID*. This method calls the refreshCharacter(ID) method on the controller's entity.

### void printController()

Parameters: none. This method prints information about the controller, for debugging purposes.

## SpriteEntity

SpriteEntity is one of the main classes that is used by this project. It provides the foundation of all objects rendered to the screen; the SpriteProp, SpriteButton, and SpriteCharacter classes all extend the SpriteEntity class. Inside this class are the following methods:

### static Bitmap decodeSampledBitmapFromResource(...)

Parameters: *Resources res, int resId, int reqWidth, int reqHeight*. This method is used to scale Bitmap images depending on the required width and hieght passed in.

### static int calculateInSampleSize(...)

Parameters: *BitmapFactory.Options options, int reqWidth, int reqHeight*. This is also used to scale Bitmap images, but is used to actually calculate the necessary sample size.

### void refreshCharacter(...)

Parameters: *String ID. This method should be overridden and filled with transitions*. For examples on transitions, see how the sample game provides overrides to this method. See also the Transitions section of this document.

### void updateView()

Parameters: none. This method can be overrided to proved extra implementation. The intrinsic implementation of this class is to 1) move the animation if x delta and y delta are nonzero, 2) update the sprite frame being rendered, 3) update the bounding box for the sprite.

### void updateBoundingBox()

Parameters: none. This method updates the spritesheet's bounding box, which controls how the user interacts with the sprite.

### void getCurrentFrame()

Parameters: none. This method updates the sprite frame being rendered. This method is used to create movement for the animation.

### String parseID(...)

Parameters: *String ID*. This method adds functionality for parsing the transition to be rendered. This allows transitions to be inherited from or initialized, giving more control and dynamism. For examples on dynamic transitions, see the overriden refreshCharacter method in the BoxRed class.

### void onTouchEvent(...)

Parameters: *SpriteView spriteView, LinkedHashMap.Entry<String, SpriteController> entry, LinkedHashMap<String, SpriteController> controllerMap, boolean touched, float xTouchedPos, float yTouchedPos*. This method is called when the user touches the screen. This method is initially left empty, since not all animations will need interactions. Different interactions have been modeled to create the sample game.

# Transitions

Spritesheets are read by using the Rect class in Android Studio; the implementation for parsing through the spritesheet is contained in the getCurrentFrame() method inside of the SpriteEntity class. This project has several different ways of implementing spritesheet transitions, these are covered below.

## Idle

By identifying a spritesheet as "idle", the SpriteController has the ability to return to that animation when necessary. The animation will loop, meaning once all frames have been parsed, the animation will start from the beginning and continue.

## Loop

By giving a Sprite the ID of "loop", the animation will loop; this functionality is described above.

## Once

By giving a Sprite the ID of "once", the animation will play one time and then transition to the "idle".

## Mirror

By giving a Sprite the ID of "mirror", the sprite controller will play the animation one time regularly, and then play the animation backwards until the first frame. The animation then stops. Delays can be specified to allow the animation to pause before playing backwards.
