using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace Ohmastium {
    class Stage {

        World world;

        public Stage() {

        }

        public void Initialize() {
            world = new World(20, 20);
            world.Initialize();
        }

        public void Update(GameTime gameTime) {
            world.Update(gameTime);
        }

        public void Draw(GameTime gameTime) {
            world.Draw(gameTime);
        }

    }
}
