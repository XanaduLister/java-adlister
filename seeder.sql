USE adlister_db;

INSERT INTO categories(type)

VALUES  ('computers'),
        ('guitars'),
        ('furniture'),
        ('bicycles'),
        ('services'),
        ('activity'),
        ('dating'),
        ('rentals'),
        ('massage'),
        ('general');

INSERT INTO users(username, email, password)

VALUES  ('Mark Stachowski', 'mark@gmail.com', '$V"67k/9U4_p)*e]r#A5./uV-Y4@_zmVXsyYW<JG_;R~uAcn4~?6Jrep~]'),
        ('Julian Lundquist', 'julian@gmail.com', '$U)r.Z_7Zh+NX:D"MBC739eQa)Fu:S@c"%y#}[C-b:P(Z3Sf~U2tGPR<Q'),
        ('Joaquin Silva', 'joaquin@gmail.com', '$;Z?79%BbR}bV9<g%5MEg5[_@a%>Y(CR$DP(b,v(@7hsC+s-cd>a"mGT6uJ@');

INSERT INTO ads(category, title, user_id, description)
VALUES
('computers', 'Notebook Pro 9', 1, 'I bought this for school but ultimately I realized this thing
is overkill
 for the things I needed a laptop for. Ive only been using it to write my papers, some Power Point projects and web browsing. This laptop is WAY overpowered for those tasks so I just want to sell it and get something more simple. What I do like about this is that its got a touch screen display, the thing can fold into tablet mode and it has one of Samsung S-Pens built right into the body. It slides right into the bottom.  The keyboard has keys that are backlit so when you use this in the dark you can see the keys easier.'
),
('guitars', 'Dillion DXC-58 Guitar (Gibson Les Paul Jr Clone) with free GoGo Tuner - $120', 2, 'This
is a rare one for you, a Dillion DXC-58, otherwise known as their les paul jr clone. The specs match up really well to a jr, and the sound is amazing. These were made so close to the Gibson specs that Dillion was issued a cease and desist order and these are no longer made. They are made very well! Even has a set neck (not a bolt on like the cheaper Epiphones) The dog ear P90 has great growl and clarity to it and the tone pots are pristine. This is the Canadian distributed Dillion jr, and is the one that is more sought after. The finish is a nice white poly finish, and is still in overall excellent condition. The tuners have been upgraded to full size Grover''s and the bridge has been swapped to a non compensated wrap around. Everything works perfectly and the strings are brand new D''addario 10s. These have since been discontinued and are selling for $400+ on reverb whenever they happen to pop up. I will also throw in a free Go Go Tuning pedal worth $70 that works perfect. No trades. Must pickup from NE side of town near windcrest. Feel free to try it out with my amp before buying. $120 or best solid offer.'
),
('furniture', 'Two Artificial Christmas Trees - $20', 3, 'I have two 6 foot tall no lights
Artificial
Christmas Trees in excellent condition, asking $20 each, for more information call Alex at 555-555-5555.'
),
('bicycles', '18" vintage Specialized Rockhopper - $50', 3, '18" vintage Specialized Rockhopper. Very rare.'
),
('services', 'Mother & daughter house cleaning!', 1, 'Lets get your home deep cleaned for the Holidays!!!

WE CAN DO SAME DAY, NEXT DAY, WEEKEND AND LAST MINUTE APPOINTMENTS IF NEEDED!

*sweeping, moping, vacuuming
*scrubbing of tubs, showers, toilets and sinks
*dusting of blinds, ceiling fans, fixtures, window seals and baseboards
* wiping of surfaces countertops, dressers, appliances, kitchen and bathroom cabinets, doors etc.

December Move Out or Move in cleaning appointments available now!!

We provide all cleaning supplies.
Please call or text for free estimates'
),
('activity', 'Male Seeks Male Workout Partner', 2, 'I am a 41 yr old fit male looking to get back in shape
and don''t like to work out alone. Seek another male, any race or age, who would like to join me in my exercise room at home. E-mail for details.Hit my personal GML xemily634'
),
('dating', 'Religion study', 3, 'Hi i am taking a world religion class for this class I have had to look
at different religions and write a paper on what I have learned I would like to connect with someone who is Muslim and willing to talk to me through email about Islam My questions are not intrusive Examples are what your religion means to you and how your religion affects you life on a daily basis I would like the insight of both men and ladies young and old If this fit you and you are willing to help me out it would be greatly appreciated Thank you for your time Please be serious and do not waist my time with foolish games.'
),
('rentals', '$625 / 1br - 523ft2 - 1/1 for only $625--Near The Medical Center', 2, '1/1 --523 sq ft,
leasing for only $625/mo at Sundance Apartments! Could be as good as $615, call for details.

Our community is walking distance from USAA and countless restaurants, and down the street from The Colonnade and H-E-B! Perfect for students attending UTSA this year, ten minutes away from UTSA main campus!

Unit is 523 sq. feet, with well optimized floor plan so it looks and feels much larger than it actually is! Spacious bedroom with plenty of closet space! Huge walk-in closet with utility shelves and room for hundreds of articles of clothing! All black or all white like-new appliances. Nice-sized kitchen with plenty of cabinet space for pots, pans, and Tupperware! Perfect for those who love to bake and cook.

Were open 8:30-5:30pm M-F and 10-5 on Saturday. Come see our model unit today, and make Sundance Apartments your new home!'
),
('massage', 'DEEP Tissue Massage Therapist/Entrepreneur', 1, 'DEEP DEEP DEEP Relief massage in the Downtown
 San Antonio area, near Codeup.  Contact Keenan for details and roommate also teaches private DEEP DEEP DEEP JAVA...'
),
('general', 'Ornamental Fishbowl - $8', 3, 'For sale ornamental fishbowl.  Fish NOT INCLUDED.'
);

INSERT INTO ads_cat (ads_id, category_id) VALUES (1, 8), (1, 10), (1, 9);