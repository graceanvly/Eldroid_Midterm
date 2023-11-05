package com.velayo.animal.midterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.velayo.animal.midterm.databinding.ActivityAnimalNamesBinding

class AnimalNamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalNamesBinding


    companion object {
        private val animalList = listOf(
            AnimalsAdapter.MyString(
                "Anaconda",
                "The Anaconda is a large snake that lives in South America. Researchers recognize four different " +
                        "species, all of which they place in the taxonomic genus Eunectes. They are members of the boa family, " +
                        "and their closest relatives include boa constrictors, tree boas, and rainbow boas."
            ),
            AnimalsAdapter.MyString(
                "Bat",
                "Bats are the only mammals that can fly. Instead of arms or hands, they have wings. " +
                        "The wings have a bone structure similar to the human hand. Between the bones are flaps of skin."
            ),
            AnimalsAdapter.MyString(
                "Chipmunks",
                "The chipmunk is reddish brown in color with a white belly. " +
                        "It has dark brown stripes down its back, a set on each side, consisting of two " +
                        "dark stripes with a white stripe in the middle.It also has a white stripe that extends " +
                        "the length of its back to the tip of its tail."
            ),
            AnimalsAdapter.MyString(
                "Dog",
                "A dog is a domestic mammal of the family Canidae and the order Carnivora. Its scientific name " +
                        "is Canis lupus familiaris. Dogs are a subspecies of the gray wolf, and they are also related to foxes " +
                        "and jackals. Dogs are one of the two most ubiquitous and most popular domestic animals in the world."
            ),
            AnimalsAdapter.MyString(
                "Elephant",
                "Elephants are the largest land mammals on earth and have distinctly massive bodies, large ears, " +
                        "and long trunks. They use their trunks to pick up objects, trumpet warnings, greet other elephants, " +
                        "or suck up water for drinking or bathing, among other uses."
            ),
            AnimalsAdapter.MyString(
                "Fish",
                "Fish are aquatic vertebrate animals that have gills but lack limbs with digits, like fingers or toes." +
                        " Recall that vertebrates are animals with internal backbones. Most fish are streamlined in their" +
                        " general body form. The word fish is the same whether it is singular or plural—you can talk about one" +
                        " fish or ten fish."
            ),
            AnimalsAdapter.MyString(
                "Giraffe",
                "The tallest land mammal, with a neck as long as 6 feet, the giraffe is also well known for the " +
                        "unique brown and white pattern on its coat (“pelage”) and its lengthy eyelashes and legs. Habitat:" +
                        " Giraffes use both semi-arid savannah and savannah woodlands in Africa."
            ),
            AnimalsAdapter.MyString(
                "Horse",
                "Horses have oval-shaped hooves, long tails, short hair, long slender legs, muscular and deep torso" +
                        " build, long thick necks, and large elongated heads. The mane is a region of coarse hairs, which" +
                        " extends along the dorsal side of the neck in both domestic and wild species."
            ),
            AnimalsAdapter.MyString(
                "Insects",
                "Insects (from Latin insectum) are pancrustacean hexapod invertebrates of the class Insecta. " +
                        "They are the largest group within the arthropod phylum. Insects have a chitinous exoskeleton, a " +
                        "three-part body (head, thorax and abdomen), three pairs of jointed legs, compound eyes and one pair " +
                        "of antennae."
            ),
            AnimalsAdapter.MyString(
                "Jaguar",
                "Jaguars have brownish-yellow fur with dark rosettes. Often confused with leopards, jaguars may be " +
                        "distinguished by the additional marks in the center of these rosettes. Jaguars also have stockier " +
                        "bodies, shorter limbs, and larger paws than leopards."
            ),
            AnimalsAdapter.MyString(
                "Kangaroo",
                "All kangaroos have short hair, powerful hind legs, small forelimbs, big feet and a long tail. " +
                        "They have excellent hearing and keen eyesight. Depending on the species, their fur coat can be red," +
                        " grey or light to dark brown. Their muscular tail is used for balance when hopping, and as another " +
                        "limb when moving about."
            ),
            AnimalsAdapter.MyString(
                "Lion",
                "Lions have strong, compact bodies and powerful forelegs, teeth and jaws for pulling down and killing" +
                        " prey. Their coats are yellow-gold, and adult males have shaggy manes that range in color from blond " +
                        "to reddish-brown to black. The length and color of a lion's mane is likely determined by age, genetics" +
                        " and hormones."
            ),
            AnimalsAdapter.MyString(
                "Monkey",
                "Closely related to apes, monkeys are primates that have a tail and usually live in trees. In some species," +
                        " the tail is longer than the rest of the body. Monkeys have a relatively large brain and they use their nimble," +
                        " grasping hands for tasks such as gathering food and picking apart fruit."
            ),
            AnimalsAdapter.MyString(
                "NightHawk",
                "Common Nighthawks are medium-sized, slender birds with very long, pointed wings and medium-long " +
                        "tails. Only the small tip of the bill is usually visible, and this combined with the large eye and " +
                        "short neck gives the bird a big-headed look."
            ),
            AnimalsAdapter.MyString(
                "Owl",
                "Most owls have huge heads, stocky bodies, soft feathers, short tails, and a reversible toe that can " +
                        "point either forward or backward. Owl's eyes face forward, like humans do. Most owl species are active" +
                        " at night, not in the daytime. There are about 250 species of owls in the world."
            ),
            AnimalsAdapter.MyString(
                "Parrot",
                "All parrots have curved beaks and all are zygodactyls, meaning they have four toes on each foot, two" +
                        " pointing forward and two projecting backward. Most parrots eat fruit, flowers, buds, nuts, seeds, and some" +
                        " small creatures such as insects. Parrots are found in warm climates all over most of the world."
            ),
            AnimalsAdapter.MyString(
                "Quail",
                "Quails are very small birds that belong to the pheasant and partridge species. The have a distinctive body" +
                        " shape with a small stocky body and long pointed wings. There are around 20 different species of quail found " +
                        "around the world, and 70 domestic quails are kept as poultry birds."
            ),
            AnimalsAdapter.MyString(
                "Rabbit",
                "Rabbits are small, furry mammals with long ears, short fluffy tails, and strong, large hind legs." +
                        " They have 2 pairs of sharp incisors (front teeth), one pair on top and one pair on the bottom. They " +
                        "also have 2 peg teeth behind the top incisors."
            ),
            AnimalsAdapter.MyString(
                "Snake",
                "A snake is a reptile with a long, thin body but no legs. Some lizards are legless and look like snakes," +
                        " however, most lizards have eyelids, and snakes do not. All snakes eat live prey, which is grabbed and" +
                        " swallowed whole without chewing it into pieces."
            ),
            AnimalsAdapter.MyString(
                "Tadpole",
                "Tadpoles are the young forms of frogs that usually hatch from eggs and live in the water." +
                        " They breathe through gills like a fish, have a tail, hang out in groups called schools and eat different " +
                        "things depending on the kind of tadpole, including plants, small animals and even other tadpoles."
            ),
            AnimalsAdapter.MyString(
                "Urchin",
                "Urchins are small sea animals that have spherical shells called tests that are typically covered in" +
                        " spines similar to those of a porcupine. Very small tube-shaped feet among the spines help them move" +
                        " slowly along the ocean floor."
            ),
            AnimalsAdapter.MyString(
                "Viper",
                "A viper has a stocky body, a wide head, and long, hinged fangs at the front of its mouth for" +
                        " injecting venom. The venom causes a very painful wound that can be fatal. Vipers target warm-blooded" +
                        " prey, such as rats and mice, and some hunt during the day. One group, the pit vipers, are mainly " +
                        "active at night."
            ),
            AnimalsAdapter.MyString(
                "Wolf",
                "Like most canids, wolves have a high body, long legs, broad skull tapering to a narrow muzzle. " +
                        "The tail is bushy and coat has a thick, dense underfur. Colors vary from light to dark gray with black " +
                        "and white interspersed, to some individuals being solid black and solid white."
            ),
            AnimalsAdapter.MyString(
                "Xerus",
                "A Xerus uses its fluffy tail as shade from the sunlight in Africa. The Xerus is commonly known as the " +
                        "African ground squirrel and is native to Africa. These animals are diurnal and mostly herbivorous. They are" +
                        " very social and live in burrows like their cousins the marmots and prairie dogs."
            ),
            AnimalsAdapter.MyString(
                "Yabby",
                "Common Yabbies are large crayfish that have a hard covering called a carapace. Physical characteristics" +
                        " include: Typically about 10-20 cm in length (approximately 4-8 inches), There are four ridges that run " +
                        "from behind the eyes on top of the head to the back of the head segment."
            ),
            AnimalsAdapter.MyString(
                "Zebra",
                "Zebras are easily recognised by their bold black-and-white striping patterns. The coat appears to be white" +
                        " with black stripes, as indicated by the belly and legs when unstriped, but the skin is black. Young or foals" +
                        " are born with brown and white coats, and the brown darkens with age."
            )

        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalNamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val blockedAnimals = intent.getStringArrayExtra("blockedAnimals")?.toSet()
        val filteredAnimalList = animalList.filter { selectedAnimal ->
            selectedAnimal.animalName !in blockedAnimals.orEmpty()
        }
        val adapter = AnimalsAdapter(filteredAnimalList) { selectedAnimalName ->
            val animal = animalList.find { it.animalName == selectedAnimalName.animalName }
            if (animal != null) {
                val intent = Intent(this, AnimalDetailsActivity::class.java)
                intent.putExtra("NAME_PARAMS", selectedAnimalName.animalName)
                intent.putExtra("DESC_PARAMS", selectedAnimalName.animalDesc)
                startActivity(intent)
            }

    }

        with(binding.animalRecyclerView) {
            layoutManager = LinearLayoutManager(this@AnimalNamesActivity)
            this.adapter = adapter
        }

        binding.manageBlock.setOnClickListener {
            val blockedAnimals = intent.getStringArrayExtra("blockedAnimals")?.toSet() ?: emptySet()
            val intent = Intent(this, ManageBlockActivity::class.java)
            intent.putExtra("blockedAnimals", blockedAnimals.toTypedArray())
            startActivity(intent)
        }


    }


}