#!/bin/bash

# Array of URLs
urls=(
  "https://content.sportslogos.net/logos/6/220/full/8190_atlanta_hawks-primary-2021.png"
  "https://content.sportslogos.net/logos/6/213/full/boston_celtics_logo_primary_19977628.png"
  "https://content.sportslogos.net/logos/6/3786/full/brooklyn_nets_logo_primary_20135043.png"
  "https://content.sportslogos.net/logos/6/5120/full/1926_charlotte__hornets_-primary-2015.png"
  "https://content.sportslogos.net/logos/6/221/full/chicago_bulls_logo_primary_19672598.png"
  "https://content.sportslogos.net/logos/6/222/full/cleveland_cavaliers_logo_primary_2023_sportslogosnet-5369.png"
  "https://content.sportslogos.net/logos/6/228/full/3463_dallas_mavericks-primary-2018.png"
  "https://content.sportslogos.net/logos/6/229/full/8926_denver_nuggets-primary-2019.png"
  "https://content.sportslogos.net/logos/6/223/full/detroit_pistons_logo_primary_20185710.png"
  "https://content.sportslogos.net/logos/6/235/full/3152_golden_state_warriors-primary-2020.png"
  "https://content.sportslogos.net/logos/6/230/full/6830_houston_rockets-primary-2020.png"
  "https://content.sportslogos.net/logos/6/224/full/4812_indiana_pacers-primary-2018.png"
  "https://content.sportslogos.net/logos/6/236/full/los_angeles_clippers_logo_primary_2019_sportslogosnet-3776.png"
  "https://content.sportslogos.net/logos/6/237/full/los_angeles_lakers_logo_primary_2024_sportslogosnet-7324.png"
  "https://content.sportslogos.net/logos/6/231/full/4373_memphis_grizzlies-primary-2019.png"
  "https://content.sportslogos.net/logos/6/214/full/burm5gh2wvjti3xhei5h16k8e.gif"
  "https://content.sportslogos.net/logos/6/225/full/milwaukee_bucks_logo_primary_20165763.png"
  "https://content.sportslogos.net/logos/6/232/full/9669_minnesota_timberwolves-primary-2018.png"
  "https://content.sportslogos.net/logos/6/4962/full/2681_new_orleans_pelicans-primary-2014.png"
  "https://content.sportslogos.net/logos/6/216/full/new_york_knicks_logo_primary_2024_sportslogosnet-7170.png"
  "https://content.sportslogos.net/logos/6/2687/full/khmovcnezy06c3nm05ccn0oj2.png"
  "https://content.sportslogos.net/logos/6/217/full/orlando_magic_logo_primary_20117178.png"
  "https://content.sportslogos.net/logos/6/218/full/7034_philadelphia_76ers-primary-2016.png"
  "https://content.sportslogos.net/logos/6/238/full/phoenix_suns_logo_primary_20143696.png"
  "https://content.sportslogos.net/logos/6/239/full/9725_portland_trail_blazers-primary-2018.png"
  "https://content.sportslogos.net/logos/6/240/full/4043_sacramento_kings-primary-2017.png"
  "https://content.sportslogos.net/logos/6/233/full/2547_san_antonio_spurs-primary-2018.png"
  "https://content.sportslogos.net/logos/6/227/full/7024_toronto_raptors-primary-2021.png"
  "https://content.sportslogos.net/logos/6/234/full/utah_jazz_logo_primary_2023_sportslogosnet-8513.png"
  "https://content.sportslogos.net/logos/6/219/full/5671_washington_wizards-primary-2016.png"
)

# Array of corresponding names
names=(
  "hawks"
  "celtics"
  "nets"
  "hornets"
  "bulls"
  "cavaliers"
  "mavericks"
  "nuggets"
  "pistons"
  "warriors"
  "rockets"
  "pacers"
  "clippers"
  "lakers"
  "grizzlies"
  "heat"
  "bucks"
  "timberwolves"
  "pelicans"
  "knicks"
  "thunder"
  "magic"
  "76ers"
  "suns"
  "trail blazers"
  "kings"
  "spurs"
  "raptors"
  "jazz"
  "wizards"
)

# Destination folder
folder="./logos"

# Create the destination folder if it doesn't exist
mkdir -p "$folder"

# Loop through the URLs and download the files
for ((i=0; i<${#urls[@]}; i++)); do
  url="${urls[$i]}"
  name="${names[$i]}.png"

  # Download the file
  wget "$url" -O "$folder/$name"
done
