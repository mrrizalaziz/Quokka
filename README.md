# Quokka
Specification
For this assignment you will write a program to simulate a scheme where quokkas on Rottnest Island in Western Australia offer tourists selfies in return for food. This section specifies the required functionality of the program. 
Background
The Quokka is a small marsupial from the south west region of Western Australia. Quokkas are found on the mainland as well as on Rottnest Island near Perth. The quokka is known to the indigenous Noongar people by various names including ban-gup and quak-a.
Quokkas are naturally curious and approachable. Their friendly nature means that they are very popular with tourists who love taking “quokka selfies". 
In recent years the population of quokkas has declined largely due to decreasing habitat caused by bushfires and land clearing. 
The quokkas, however, are resourceful. An entrepreneurial group of quokkas on Rottnest Island has decided to ensure their survival by posing for selfies with tourists in exchange for food - the Quokka Selfie Quest. Each day a flock of tourists arrives by ferry to Rottnest Island. The quokkas approach the tourists and offer to pose for selfies. The quokkas are willing to pose with individual or groups of tourists. They are willing to allow photos or videos, or pose for a sketch. 
In order to decide how much to charge for their services the quokkas have requested a simulation of the Quokka Selfie Quest enterprise for a period of 30 days. At the end of the simulation they will receive a report indicating whether they can receive sufficient food for survival. 
Quokka selfie quest simulation
The Quokka Selfie Quest program will simulate 30 days of food earned from selfies by a group of quokkas. The simulation steps through each of the 30 days. At the end of the simulation the quokka population survival is reported. 
Program start up 
The program begins by displaying a brief welcome message. 
The number of tourist groups for each of the 30 days is read in from a file tourist.txt. The file will contain 30 comma separated numbers, with each number representing the number of groups of tourists for one day. The groups vary in size from 1 to 6 tourists. There is no other reading from the file during the running of the program.
The user is then prompted for the number of quokkas in the population. From this data, the program creates a collection of quokkas. Each quokka will have a unique identification code, a flag indicating whether it has a baby in its pouch, food supply and a status indicating whether it is alive or not. The details of these are as follows:
1. The unique identification code will be in the following format: Qnnn (where nnn represents a sequence of three digits).
2. There is a 20% chance that a quokka will have a baby quokka in its pouch.
3. The initial food supply is 2 bags for each quokka without a baby and 3 bags for each quokka with a baby. 
4. All quokkas will be alive at the start of the simulation. 
Specific actions each day
1. Set up tourist data:
The number of tourist groups for the day is used to set up a collection of tourist groups. Each tourist group in the collection will have a size, type of selfie and a status indicating whether the selfie has been taken. The details of these are as follows:
The group size will vary from 1-6. There is a 30% chance of a group of 1 (an individual), 30% for a group of 2 and 10% for each of the other group sizes.
The selfie type can be a photo, video, or sketch, with 60% photos, 35% videos, and 5% sketches.

oThe length of a video selfie will be a random time from 1 to 60 seconds.
oThe sketch will be either a 5 minute pose or a 10 minute pose. Each are equally likely.
Sketches are only possible for an individual (group of 1).
All tourist groups will have a status indicating no selfie has been taken at the start of the day. 
2. Quokkas offer tourists selfies:
The quokkas will take turns to offer the tourists a selfie. 
The order in which the quokkas approach the tourists depends on the size of the food stores that the quokkas have. The quokkas with the lowest supply of food are more desperate and will approach the tourists first. 
If there are not many tourists on a particular day then some quokkas may miss out on a chance to take a selfie.
If there are a large number of tourists then the quokkas may need to approach the tourists a second time (or more). The quokkas will continue offering selfies until all tourist groups have had selfies.
Each tourist group will only have one selfie.
Payment for selfies:
The number of bags of food earned for each selfie type is as follows:
oindividual photo - 1 bag 
ogroup photo - 2 bags 
oindividual video - 1 bag per 20 seconds of video
ogroup video - 2 bags per 20 seconds of video
oindividual sketch - 6 bags for a 5 minute pose and 10 bags for a 10 minute pose
If the quokka has a baby in their pouch then the payment is doubled.
Quokka food intake
Quokkas eat two bags of food a day or three bags if they have a baby.
Quokkas are able to store their food if they have an excess at the end of each day.
If quokkas do not eat any food for two days in a row then unfortunately they die. 
If quokkas do not each enough food for five days during the 30 days then they die.
Quokka births
Each day the probability of each quokka without a baby in their pouch giving birth to a new quokka is 0.05. (Hint: to calculate the probability of event, generate a random number from 1 to 100. There is a 1% chance of each of these numbers being generated so you can nominate numbers 1-5 for a quokka birth).
At the end of each day a summary of the population is displayed with the number of live quokkas, number of deaths, number of new quokkas born and total food supply. Note that the count of quokkas includes baby quokkas.
Specific actions at the completion of the 30 day simulation
 positive number indicates that the population is sustainable
The following summary is displayed on the screen. 
The QSQSF
The QPSF
Number of days where quokkas died through lack of food.
A summary is written to the file populationFinal.txt. The details written to the file will be the numbers of live quokkas, newborn quokkas, dead quokkas and total food supply.
