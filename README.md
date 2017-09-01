# Sprite Renderer for Android Studio

This repository contains a simple implementation of a "sprite renderer" for Android Studio. Android Studio does not provide it's users with any innate sprite rendering/animation capabilities; it allows users to use their Bitmap, SurfaceView, and ImageView classes, however there is no package that contains a complete way to use spritesheets. This project is intended to provide users with that ability.

# What Is "Sprite Rendering"?

The term "sprite rendering" refers to the use of spritesheets in order to implement animations. An example of a spritesheet from this repositoy is shown below.

![Spritesheet](/app/src/main/res/mipmap-xxxhdpi/spritesheet_box_rotate_up_red_mirror.png)

If you would like to make a game or app that uses this form of spritesheet, clone this repository and start by editing the sample game. A description of each class and its functions can be found below.

# Class Definitions

## SpriteEntity

Spritesheets are read by using the Rect class in Android Studio; the implementation for parsing through the spritesheet is contained in the getCurrentFrame() function inside of the SpriteEntity class. This project has several different ways of implementing spritesheet animations, these are covered below.

### Idle

By identifying a spritesheet as "idle", the SpriteController has the ability to return to that animation when necessary. The animation will loop, meaning once all frames have been parsed, the animation will start from the beginning and continue.

### Loop

By giving a Sprite the ID of "loop", the animation will loop; this functionality is described above.

### Once

By giving a Sprite the ID of "once", the animation will play one time and then transition to the "idle".

### Mirror

By giving a Sprite the ID of "mirror", the sprite controller will play the animation one time regularly, and then play the animation backwards until the first frame. The animation then stops. Delays can be specified to allow the animation to pause before playing backwards.
