using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace Ohmastium {
    public class Game1 : Game {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        Texture2D ohTexture;
        Texture2D fuTexture;
        Stage stage;
        
        public Game1() {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";
            stage = new Stage();
        }

        protected override void Initialize() {
            base.Initialize();
            stage.Initialize();
        }
        
        protected override void LoadContent() {
            spriteBatch = new SpriteBatch(GraphicsDevice);
            ohTexture = Content.Load<Texture2D>("ohmastium");
            fuTexture = Content.Load<Texture2D>("fuelium");
        }

        protected override void UnloadContent() {
            
        }

        protected override void Update(GameTime gameTime) {
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed || Keyboard.GetState().IsKeyDown(Keys.Escape)) {
                Exit();
            }
            base.Update(gameTime);
            stage.Update(gameTime);

            
        }

        protected override void Draw(GameTime gameTime) {
            GraphicsDevice.Clear(Color.Red);
            
            base.Draw(gameTime);
            stage.Draw(gameTime);

            spriteBatch.Begin();
            spriteBatch.Draw(ohTexture, new Vector2(0, 0), Color.White);
            spriteBatch.Draw(fuTexture, new Vector2(400, 0), Color.White);
            spriteBatch.End();
        }
    }
}