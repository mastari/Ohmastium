using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace Ohmastium {
    class World {

        //SpriteBatch sb;

        public int w, h;
        public Dictionary<Vector2, Block> blocks;

        public World(int w, int h) {
            this.w = w;
            this.h = h;
        }

        public void GenerateWorld() {
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    Vector2 pos = new Vector2(i, j);
                    Block b = new Block(i, j, "dirt");
                    blocks.Add(pos, b);
                }
            }
        }

        public void Initialize() {
            blocks = new Dictionary<Vector2, Block>();
            //sb = new SpriteBatch(Program.game.GraphicsDevice);
        }

        public void Update(GameTime gameTime) {

        }

        public void Draw(GameTime gameTime) {
            //sb.Begin();
            //foreach(KeyValuePair<Vector2, Block> block in blocks) {
            //    Rectangle r = new Rectangle((int)block.Key.X, (int)block.Key.Y, 50, 50);
            //    sb.Draw(new Texture2D(Program.game.GraphicsDevice, 400, 400), r, Color.Blue);
            //}
            //sb.End();
        }
    }
}
