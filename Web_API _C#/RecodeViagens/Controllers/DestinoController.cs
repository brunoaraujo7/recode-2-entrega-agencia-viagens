using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using RecodeViagens.Models;

namespace RecodeViagens.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DestinoController : ControllerBase
    {
        private readonly GeralDbContext _context;

        public DestinoController(GeralDbContext context)
        {
            _context = context;
        }

        // GET: api/Destino
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Destino>>> GetDestinos()
        {
            return await _context.Destinos.ToListAsync();
        }

        // GET: api/Destino/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Destino>> GetDestino(long id)
        {
            var destino = await _context.Destinos.FindAsync(id);

            if (destino == null)
            {
                return NotFound();
            }

            return destino;
        }

        // PUT: api/Destino/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutDestino(long id, Destino destino)
        {
            if (id != destino.Id)
            {
                return BadRequest();
            }

            _context.Entry(destino).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DestinoExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Destino
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Destino>> PostDestino(Destino destino)
        {
            _context.Destinos.Add(destino);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetDestino", new { id = destino.Id }, destino);
        }

        // DELETE: api/Destino/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteDestino(long id)
        {
            var destino = await _context.Destinos.FindAsync(id);
            if (destino == null)
            {
                return NotFound();
            }

            _context.Destinos.Remove(destino);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool DestinoExists(long id)
        {
            return _context.Destinos.Any(e => e.Id == id);
        }
    }
}
