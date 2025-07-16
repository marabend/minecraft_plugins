package org.setup.minecraft;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

    // https://namemc.com/

    @Override
    public void onEnable() {
        ProfileService resolver = HttpRepositoryService.forMinecraft();
        ParallelProfileService service = new ParallelProfileService(resolver, 3);

        try {
            service.findAllByName(Arrays.asList("Hello", "Test"), new Predicate<Profile>() {
                @Override
                public boolean test(Profile profile) {
                    return false;
                }
            });
            /*

            Profile profile = resolver.findByName("Notch");

            if(profile != null) {
                System.out.println(profile.getUniqueId());
            } else {
                System.out.println("failed to retrieve profile!");
            }

            System.out.println(profile.getUniqueId());

             */
           ImmutableList<Profile> profiles =  resolver.findAllByName(Arrays.asList("Notch", "Stephen", "Banana"));


        } catch(IOException e) {
            e.printStackTrace();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
