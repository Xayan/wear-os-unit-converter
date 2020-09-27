# Wear OS Unit Converter

Few days with a smartwatch were enough for me to get fascinated by these devices so much I wanted to create my own app for them. One thing I noticed was that there was no free app for unit conversion - so now there is!

This project is meant simply for learning, however I would like to publish it eventually. Right now Wear OS is still missing many features, and I'd like to do something about that.

## UI

![](https://i.imgur.com/8SEyJsr.png)  |  ![](https://i.imgur.com/ftdScmR.png)
:-------------------------:|:-------------------------:
**Round watch face**           |  **Square watch face**

Round watch faces, however nice looking, are somewhat problematic, as they can fit less information in a structured way than square screens. Therefore, there are slight differences in their layouts, so the entire screen is visible without scrolling and there are no empty spaces.

## Features

This is a work in progress, but so far the following things work:

- editing the text field with number-only keyboard
- numbers are formatted according to user's locale
- unit swap button
- the UI updates accordingly to the data of primitive types in app's memory, which will be important later for saving data in user preferences so the user's choices are persistent

## To be added

- manual unit switching
- converters for other types of measurements
- saving data to user preferences and then loading it on app startup
- settings menu
- copy to clipboard button
- optional navigation gestures